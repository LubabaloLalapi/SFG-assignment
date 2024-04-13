# SFG-assignment

WebSocketConfig

@EnableWebSocketMessageBroker: This annotation is used to enabled the web socket in our application.
class WebSocketConfig implements WebSocketMessageBrokerConfigurer: We implemented a WebSocketMessageBrokerConfigurer interface because it contains methods to configure or established the connection with WebSocket.
configureMessageBroker(): This method is used to route or send the message received from one client to the other client.

config.enableSimpleBroker(“/lesson”): This is used to enabling the message broker to the mentioned endpoint. For example, if any message whose endpoints start with /lesson, then it will redirect to the message broker, and the message broker will route or send the messages to all the subscribed or registered clients.

config.setApplicationDestinationPrefixes(“/app”): Once the message has been processed, controller will send to the broker channel.
registerStompEndpoints(): This method used for registering the WebSocket endpoints or API which the client used to connect our WebSocket Server. So in the above code, the name of that endpoint is “/gs-guide-websocket”.

Stomp: This word in the method registerStompEndpoints() signify that it derived from STOMP implementation which is present in Spring Framework. The full form or acronym of this word is the Simple Text Oriented Messaging Protocol. It is just a protocol to send and receive the message data.

SmsController

@RequestMapping: This annotation make sure that whenever POST request comes from /sms endpoint or API, then It accepts the JSON parameter in and produces the response in the form of JSON. At the same when the request comes on /sms endpoint, it will be mapped with the method smsSubmit() .

@RequestBody: Whatever the request parameters received from UI or FrontEnd, it will mapped to the SmsPojo class Object.

service.send(sms): When we received the message and to parameters from UI side, and after mapping it with SmsPojo Object, we are calling a send(sms) method which is present in the service class, Yet we didn’t create a service class, but in next step will create a service class for sending SMS.

This method will send the SMS message to the number which you provides in to parameter from the UI side. Actually here the SMS will send from Twilio phone number.
As we are using the Twilio service with Spring Boot, so first we need to register in Twilio, and once the registration will be done, the Twilio will send the SMS on behalf of you.

webSocket.convertAndSend(): This method calling statement is used to send the message to all the registered or subscribed clients.

SmsService

ACCOUNT_SID, AUTH_TOKEN, FROM_NUMBER: As I told you earlier we are using Twilio for sending the SMS Messages, so when you registered on Twilio account you will get the ACCOUNT_SID, AUTH_TOKEN, and FROM_NUMBER. Just copy and paste the actual data from Twilio.

Twilio.init(ACCOUNT_SID, AUTH_TOKEN): This will initialize the Twilio in Spring Boot Application.
Message.creator(): In this method, we are passing all necessary credentials details such as SMS text, phone number, etc. and finally it will send the SMS to the mentioned mobile number in the to variable.
