#include <LiquidCrystal_I2C.h>
#include <Wire.h> 
LiquidCrystal_I2C lcd(0x27,16,2); 
LiquidCrystal_I2C lcd2(0x27,16,2);
void setup()
{
  lcd.init();                    
  lcd.backlight();
  lcd.setCursor(2,0);
  lcd.print("Arduinokit.vn");
  lcd.setCursor(0,1);
  lcd.print("Xin chao cac ban");
  
  lcd2.init();                    
  lcd2.backlight();
  lcd2.setCursor(2,0);
  lcd2.print("Arduinokit.vn");
  lcd2.setCursor(0,1);
  lcd2.print("Xin chao cac ban");
}

void loop()
{
}
