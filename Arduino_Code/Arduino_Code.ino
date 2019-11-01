//Defining pin variables

#include<SoftwareSerial.h>
void sendStatus(char* message){
Serial.write(message);
}

int Relay1=6;
int Relay2=7;
int Relay3=8;
int Relay4=9;




void setup() {
  Serial.begin(9600);
  pinMode(12,OUTPUT); // when motion detected turn on off the led
  pinMode(2, INPUT);   // for the pir sensor
  pinMode(13, OUTPUT); // forthe Leds
  pinMode(Relay1,OUTPUT);
  pinMode(Relay2,OUTPUT);
  pinMode(Relay3,OUTPUT);
  pinMode(Relay4,OUTPUT);
  
  digitalWrite(Relay1,HIGH);
  digitalWrite(Relay2,HIGH);
  digitalWrite(Relay3,HIGH);
  digitalWrite(Relay4,HIGH);
}

void loop() {
  // put your main code here, to run repeatedly:
  if (digitalRead(2)== HIGH)
      {
       digitalWrite(12, HIGH); 
       Serial.println("Motion Detected");
       delay(1000); // for the led to be high for 1 sec when motion detected
        }

  else
      {
       digitalWrite(12, LOW);
       Serial.println("No Motion Detected");
       delay(1000);  // for the led to be low for 1 sec when no motion detected
       
        }  
          
  if (Serial.available() > 0)
  {
    char data = Serial.read(); // reading the data received from the bluetooth module
    switch (data)
    {
     
      case 'A': digitalWrite(Relay1, LOW);
        sendStatus("ON");
        break;
    // when a is pressed on the app on your smart phone
      
      case 'a': digitalWrite(Relay1, HIGH);
        sendStatus("OFF");
        break; // when d is pressed on the app on your smart phone

      case 'B': digitalWrite(Relay2, LOW);
        sendStatus("ON");
        break; // when a is pressed on the app on your smart phone
      
      case 'b': digitalWrite(Relay2, HIGH);
        sendStatus("OFF");
        break; // when d is pressed on the app on your smart phone

      case 'C': digitalWrite(Relay3, LOW);
        sendStatus("ON");
        break; // when a is pressed on the app on your smart phone
      
      case 'c': digitalWrite(Relay3, HIGH);
        sendStatus("OFF");
        break; // when d is pressed on the app on your smart phone
        
      case 'D': digitalWrite(Relay4, LOW);
        sendStatus("ON");
        break; // when a is pressed on the app on your smart phone
      
      case 'd': digitalWrite(Relay4, HIGH);
        sendStatus("OFF");
        break; // when d is pressed on the app on your smart phone 

      case 'E': digitalWrite(13, HIGH);
        sendStatus("ON");
        break; // when a is pressed on the app on your smart phone
      
      case 'e': digitalWrite(13, LOW);
        sendStatus("OFF");
        break; // when d is pressed on the app on your smart phone
      default : break;
    }
    
  }
  
  delay(50);
}
