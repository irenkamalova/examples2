package com.kamalova;

// need javax.mail.jar
// maybe smtp.jar and activation.jar (?)
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mail {
//    public static void main(String[] args) {
//        String from = "from@gmail.com"; // sender email
//        String to = "to@mail.ru"; // receiver email
//        String host = "smtp.gmail.com"; // mail server host
//
//        // final ?
//        // app need permission to use the System Properties object
//        // (alternatively, the application can use its own Properties object)
//        Properties properties = System.getProperties();
//
//        properties.setProperty("mail.smtp.socketFactory.port", "465");
//        properties.setProperty("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        properties.setProperty("mail.smtp.port", "465");
//        properties.setProperty("mail.smtp.ssl.enable", "true");
//        // javax.mail.MessagingException: Could not connect to SMTP host: smtp.gmail.com, port:
//        // smtp - port 25
//        // smtps - port 465
//
//        properties.setProperty("mail.smtp.host", host);
//        properties.setProperty("mail.smtp.user", from);
//        properties.setProperty("mail.smtp.auth", "true");
//        properties.setProperty("mail.smtp.starttls.enable", "true");
//        //properties.setProperty("mail.smtp.port", "587");
//
////        try {
////            properties.load(Mail.class.getClassLoader().getResourceAsStream("mail.properties"));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        Session session = Session.getInstance(properties,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication("your@gmail.com", "pswd");
//                    }
//                }); // default session
//        // поможет отловить ошибки и увидеть, что происходит:
//        session.setDebug(true);
//
//        try {
//            MimeMessage message = new MimeMessage(session); // email message
//            message.setFrom(new InternetAddress(from)); // setting header fields
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject("Test Mail from Java Program"); // subject line
//            // actual mail body
//            message.setText("You can send mail from Java program by using mail API, " +
//                    "but you need" + "couple of more JAR files e.g. smtp.jar and activation.jar");
//            // Send message
//
//            Transport.send(message);
//            //Transport transport = session.getTransport();
//            //transport.connect(from, "pwd");
//            //transport.sendMessage(message, message.getAllRecipients());
//            //transport.close();
////          старый способ:
////            Transport.send(message);
//
//            System.out.println("Email Sent successfully....");
//
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }

        // Username and Password not accepted
//    }
}

/*
Используем

Java Mail API - javax.mail
SMTP - Simple Message Transport Protocol
SMTP демон под Linux - использует порт 25
Также можно добавлять  SSL (Socket Security Layer) или TSL (Transport Security Layer)
 */
