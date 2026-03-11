import java.util.*;

class ParkingLot{

    String[] table = new String[10];

    int hash(String plate){
        return Math.abs(plate.hashCode()) % table.length;
    }

    public void park(String plate){

        int index = hash(plate);

        while(table[index]!=null){
            index = (index+1)%table.length;
        }

        table[index] = plate;

        System.out.println("Parked at "+index);
    }

    public void exit(String plate){

        for(int i=0;i<table.length;i++){
            if(plate.equals(table[i])){
                table[i]=null;
                System.out.println("Exited from "+i);
            }
        }
    }

    public static void main(String[] args){

        ParkingLot p = new ParkingLot();

        p.park("ABC123");
        p.park("XYZ999");
        p.exit("ABC123");
    }
}