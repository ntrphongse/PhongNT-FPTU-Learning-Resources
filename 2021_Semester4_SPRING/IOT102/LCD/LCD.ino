#include <LiquidCrystal.h>
LiquidCrystal lcd(12,11,5,4,3,2); // Sets the interfacing pins
float temp;
int tempPin = 0;
void setup() {
  // put your setup code here, to run once:
  lcd.begin(16,2); // initializes the 16x2 LCD
}

void loop() {
  // put your main code here, to run repeatedly:
  temp = analogRead(tempPin);
  // read analog volt from sensor and save to variable temp
   temp = temp * 0.48828125;
   // convert the analog volt to its temperature equivalent
  lcd.setCursor(0,0); // Set cursor at row 0 column 0
  lcd.print("TEMPERATURE"); // prints 16x2 LCD MODULE
  lcd.setCursor(2,1); // Set cursor at row 1 column 2
  lcd.print(temp); // print HELLO WORLD
  delay(1000);
}
