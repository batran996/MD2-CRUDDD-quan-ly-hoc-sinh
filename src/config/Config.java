package config;

import java.io.*;

public class Config<T>{
    public void write(T data,String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            fos.close();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
    public T read(String path){
        T data = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (T) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException e) {
            System.out.println("Err");;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }



}
