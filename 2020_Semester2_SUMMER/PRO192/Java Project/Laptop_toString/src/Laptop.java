/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Laptop {
    private String name;
    private CPU core;
    private Screen src;
    private int[] serial = new int[9];
    
    class Screen {
        float size;

        public Screen() {
            size = 10;
        }

        public Screen(float size) {
            this.size = size;
        }

        public float getSize() {
            return size;
        }

        public void setSize(float size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Screen {size: " + size + "}";
        }        
    }
    
    class CPU {
        int gen;

        public CPU() {
            gen = 5;
        }

        public CPU(int gen) {
            this.gen = gen;
        }

        public int getGen() {
            return gen;
        }

        public void setGen(int gen) {
            this.gen = gen;
        }

        @Override
        public String toString() {
            return "CPU{" + "gen=" + gen + '}';
        }
    }

    public Laptop() {
        name = "";
        core = new CPU();
        src = new Screen();
        for (int i = 0; i<= 8; i++)
        {
            serial[i] = 0;
        }
    }

    public Laptop(String name, float size, int gen, int[] serial){
        this.name = name;
        this.src = new Screen(size);
        this.core = new CPU(gen);
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CPU getCore() {
        return core;
    }

    public void setCore(int gen) {
        this.core.setGen(gen);
    }

    public float getSrc() {
        return src.getSize();
    }

    public void setSrc(float size) {
        this.src.setSize(size);
    }

    public String getSerial() {
        String rSerial = "";
        for (int i = 0; i <= 8; i++)
        {
            rSerial += serial[i];
        }
        return rSerial;
    }

    public void setSerial(int[] serial) {
        this.serial = serial;
    }
    
    boolean is7thGen()
    {
        return core.gen == 7;
    }
    
    String displayLotofLaptop()
    {
        if (serial[6] == 9)
            return "Best Seller";
        return "" + serial[6];
    }
    
    String displayCreateDate()
    {
        String CreateDate = "";
        for (int i=0; i <= 5; i++)
            CreateDate += serial[i];
        return CreateDate;
    }
    
    @Override
    public String toString() {
        String rre = "Laptop{" + "name=" + name + ", core=" + core + ", src=" + src + ", serial=" + getSerial() + '}';
        if (is7thGen())
            rre += "\nIt is the 7th Gen!";
        rre += "\nLot of Laptop: " + displayLotofLaptop();
        rre += "\nCreated Date: " + displayCreateDate();
        return rre;
    }
}
