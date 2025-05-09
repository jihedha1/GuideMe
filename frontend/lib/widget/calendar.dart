import 'package:flutter/material.dart';
import 'package:table_calendar/table_calendar.dart';
import '/view/calendar_screen.dart';
import 'package:intl/intl.dart';

class calendar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    String today = DateFormat.yMMMMEEEEd('fr_FR').format(DateTime.now());

    return GestureDetector(
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => CalendarScreen()),
        );
      },
      child: Container(
        height: 180,
        width: 160,
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(15),
          boxShadow: [
            BoxShadow(
              color: Colors.black26,
              blurRadius: 6,
              offset: Offset(2, 4),
            ),
          ],
        ),
        child: Column(
          children: [
            // ✅ En-tête
            Container(
              decoration: BoxDecoration(
                color: Colors.blue,
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(15),
                  topRight: Radius.circular(15),
                ),
              ),
              padding: EdgeInsets.symmetric(vertical: 8),
              child: Center(
                child: Text(
                  "Calendrier",
                  style: TextStyle(
                      color: Colors.white, fontWeight: FontWeight.bold),
                ),
              ),
            ),
            // ✅ Date d'aujourd'hui
            Expanded(
              child: Center(
                child: Text(
                  today,
                  textAlign: TextAlign.center,
                  style: TextStyle(fontSize: 14, fontWeight: FontWeight.w500),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
