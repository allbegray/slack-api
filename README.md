slack-api
=============
A Java client for the Web APIs, Incoming Webhooks, Slackbot

## Example
```java

SlackWebApiClient webApiClient = SlackClientFactory.createWebApiClient(token);

SlackbotClient slackbotClient = SlackClientFactory.createSlackbotClient(slackbotUrl);

SlackbotClient = SlackClientFactory.createSlackbotClient(slackbotUrl);

```

### Slack API compatibility
auth, channels, chat, emoji, files, groups, im, mpim, pins, reactions, stars, team, users

### Coming soon next
search, oauth, rtm Api
