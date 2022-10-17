package Bai1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String source = "K:\\Tai Lieu Hoc Rikkei Academy\\Module 2\\untitled32\\src\\Bai1\\source";
        String dest = "K:\\Tai Lieu Hoc Rikkei Academy\\Module 2\\untitled32\\src\\Bai1\\dest";
        copyFileText(source,dest);
    }

    private static void copyFileText(String source, String dest) {
        Scanner sc = new Scanner(System.in);
        File sourceFile = new File(source);
        File destFile = new File(dest);
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại ");
            return;
        }
        boolean next = true;
        if (destFile.exists()) {
            next = false;
            System.out.println("Tệp đính đã tồn tại Bạn có muốn ghi đè lên ? ");
            System.out.println("1.Yes     2.No");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Tệp sẽ ghi đè ");
                    next = true;
                    break;
                case 2:
                    System.out.println("Tệp sẽ không bị ghi đè");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        if (next) {
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
            } catch (IOException e) {
                System.out.println("Lỗi");
            }
            System.out.println("Đã sao chép thành công");
        }
        System.out.println("CÚT");
    }
}
