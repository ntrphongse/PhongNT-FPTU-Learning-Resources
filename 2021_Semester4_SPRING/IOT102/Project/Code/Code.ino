#include "LiquidCrystal_I2C.h"
const int DANGEROUS_GAS = 100;
int interval = 1000;
int potPinDef = A3;
int defHeatValue;
int defGasValue;

int gasPin = A0;
int gasValue;
int firePin = 2;
int fireValue;
int heatPin = A1;
int heatValue;
int bellPin = 4;

//Create the LCD object

LiquidCrystal_I2C lcd(0x27, 16, 2);

void setup() {
  pinMode(firePin,INPUT);

  //Set up the LCD's rows and columns
  lcd.init();
 lcd.backlight();

  //Activate bell's digital pin
  pinMode(bellPin,OUTPUT);
  lcd.print("Welcome! Welcome!");

  delay(interval);
}

void alarm(){
  digitalWrite(bellPin,HIGH);
  delay(3000);
  digitalWrite(bellPin,LOW);
}

void displayTemp(int reading){
    delay(interval);
    lcd.clear();

    //Set the LCD to start displaying on the first row
    lcd.setCursor(0,0);

    
    //Display the threshold value
    lcd.print("THRESHOLD(C):");
    lcd.print(defHeatValue);

    
    //Set the LCD to start displaying on the second row
    lcd.setCursor(0,1);

    //Print out current temperature
    lcd.print("CURRENT(C):");
    lcd.print(reading);
    
    
    //Room's temperature exceeds specified value
    if(reading > defHeatValue){
      lcd.setCursor(0,0);
      lcd.print("MAXIMUM EXCEEDED!");
      
      
      alarm();
      }    
}

void displayGas(int reading){
  
  delay(interval);
  lcd.clear();
  
  
  //No gas leakage yet
  if(reading < DANGEROUS_GAS){
      lcd.setCursor(0,0);
      lcd.print(" NORMAL STATUS");

    }
    //Gas leakage exceeds the recommended level
    else if(reading >= DANGEROUS_GAS){
      lcd.setCursor(0,0);
      lcd.print(" GAS DETECTED!");

      alarm();
      }
}


void displayFire(int reading){
    delay(interval);
    lcd.clear();
    lcd.setCursor(0,0);


  //No fire detected
  if(reading == 0){
      lcd.setCursor(0,1);
      lcd.print(" NO FLAME");

    
    }
    //A fire's IR is sufficient to decrease the sensor's thermal resistance 
    else{
      lcd.setCursor(0,1);
      lcd.print("FLAME DETECTED");
  
      alarm();
    }
  
  }

void loop() {
  
  lcd.clear();
  //Read the default thresholds, adjustable with the potentiometer
  defHeatValue = (analogRead(potPinDef)*5.0/1024)*100;
  
  //Read the MQ2's sensor values
  gasValue = analogRead(gasPin);
  //Read the fire sensor values
  fireValue = digitalRead(firePin);
  //Read the heat sensor values
  heatValue = (analogRead(heatPin)*5.0/1024)*100;
  
  displayTemp(heatValue);
  
  displayGas(gasValue);
  
  displayFire(fireValue);

  delay(interval);
  
}
