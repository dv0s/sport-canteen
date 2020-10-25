package nl.avd.dvo.sportcanteen.logic;

import java.io.*;

public class RegisterObjectIO {

    public static void writeRegister(String fileName, Register register){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(register);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Register readRegister(String fileName){
        Register register = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
           register = (Register) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return register;
    }
}
