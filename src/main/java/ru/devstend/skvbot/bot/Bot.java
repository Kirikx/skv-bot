package ru.devstend.skvbot.bot;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class Bot extends TelegramLongPollingBot {

  private static final ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(Include.ALWAYS);

  @Autowired
  private MongoTemplate mongoTemplate;

  @Value("${bot.name}")
  private String botUsername;

  @Value("${bot.token}")
  private String botToken;

  @Override
  public String getBotUsername() {
    return botUsername;
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  @SneakyThrows
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage()) {
      Message message = update.getMessage();

      Document doc = Document.parse(objectMapper.writeValueAsString(update));
      mongoTemplate.insert(doc, "foo");

      SendMessage response = new SendMessage();
      Long chatId = message.getChatId();
      response.setChatId(String.valueOf(chatId));
      String text = message.getText();
      response.setText(text);
      try {
        execute(response);
        log.info("Sent message \"{}\" to {}", text, chatId);
      } catch (TelegramApiException e) {
        log.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
      }
    }
  }

  @PostConstruct
  public void start() {
    log.info("username: {}, token: {}", botUsername, botToken);
  }
}
