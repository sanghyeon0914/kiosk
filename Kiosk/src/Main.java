import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> bugerMenu = new ArrayList<>();
        int choice;
        boolean running = true; // 실행 여부를 제어하기 위한 플래그 변수 running 선언
        //boolean은 참(true) 또는 거짓(false) 값을 저장하는 기본 데이터 타입(primitive type) 이다.

        bugerMenu.add(new MenuItem("ShackBurger", 69000, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugerMenu.add(new MenuItem("SmokeShack", 89000, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        bugerMenu.add(new MenuItem("Cheeseburger", 69000, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        bugerMenu.add(new MenuItem("Hamburger", 54000, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (running) { //while 문은 true 일 경우 계속 반복 false 일 경우 중지/ running을 true로 선언 함으로 무한 반복
            System.out.println("=== [ MAIN MENU ] ==="); //메인 메뉴를 표기
            System.out.println("1. Burgers");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.nextLine(); // 버퍼 초기화
                continue;
            }

            switch (choice) {
                case 1 :
                    // 메뉴 출력
                    System.out.println("\n==== 햄버거 메뉴 ====");
                    for (int i = 0; i < bugerMenu.size(); i++) {
                        System.out.println((i + 1) + ". " + bugerMenu.get(i).getName() + " - " + bugerMenu.get(i).getPrice() + "원");
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.print("메뉴 번호를 선택하세요: ");

                    // 사용자 입력 받기
                    try {
                        choice = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                        scanner.nextLine(); // 버퍼 초기화
                        continue;
                    }

                    // 입력된 숫자 처리
                    if (choice == 0) {
                        System.out.println("메인 화면으로 돌아갑니다.\n");
                        break;
                    } else if (choice > 0 && choice <= bugerMenu.size()) {
                        MenuItem selectedItem = bugerMenu.get(choice - 1);
                        System.out.println("\n=== 선택한 메뉴 ===");
                        selectedItem.display();
                    } else {
                        System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 선택하세요.");
                    }
                    break;
                    
                case 0 :
                    System.out.println("키오스크를 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
        scanner.close();
    }
}