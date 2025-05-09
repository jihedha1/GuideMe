import 'package:flutter/material.dart';
import '/view/chatbot_screen.dart'; // Importer la vue du chatbot

class chatbot extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => ChatbotScreen()), // Navigation
        );
      },
      child: Container(
        height: 180,
        width: 160,
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(15),
          image: DecorationImage(
            image: AssetImage('assets/image/chat.png'),
            fit: BoxFit.cover,
          ),
        ),
        child: Container(
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(15),
            color: Colors.black.withOpacity(0.3), // Fond semi-transparent sur l'image
          ),
          child: Center(

          ),
        ),
      ),
    );
  }
}