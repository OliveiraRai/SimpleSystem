import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringUtil myUtils = new StringUtil();

        String username = null;
        String password = null;
        boolean isLogged = false;

        while(true) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Sign up");
            System.out.println("2 - Log in");
            System.out.println("3 - Profile");
            System.out.println("4 - Log out");
            System.out.println("================");

            try {
                System.out.print("Choose an option: ");
                String choice = input.nextLine().trim();

                if(choice.isEmpty()) {
                    System.out.println();
                    System.out.println("Please, make sure to digit something.");
                    System.out.println();
                    continue;
                }
    
                int intChoice = Integer.parseInt(choice);
    
                if(intChoice < 1 || intChoice > 4) {
                    System.out.println();
                    System.out.println("Choose between 1 and 4.");
                    System.out.println();
                }
    
                switch (intChoice) {
                    case 1:
                        if(username == null) {
                            System.out.println();
                            System.out.print("Enter username: ");
                            username = input.nextLine().trim();

                            if(myUtils.hasInternalSpaces(username)) {
                                System.out.println();
                                System.out.println("Please, do not use blank spaces between text.");
                                System.out.println();
                                username = null;
                                continue;
                            }
    
                            System.out.print("Enter password: ");
                            password = input.nextLine().trim();

                            if(myUtils.hasInternalSpaces(password)) {
                                System.out.println();
                                System.out.println("Please, do not use blank spaces between text.");
                                System.out.println();
                                username = null;
                                password = null;
                                continue;
                            }
    
                            if(username.isEmpty() || password.isEmpty()) {
                                System.out.println();
                                System.out.print("Please, fill all fields.");
                                System.out.println();
                                break;
                            } 
                            
                            System.out.println();
                            System.out.println("Successfully created an account!");
                            System.out.println();
                            break;
                        } else {
                            System.out.println();
                            System.out.println("There's already an account.");
                            System.out.println();
                            break;
                        }
                    
                    case 2:
                        if(username == null) {
                            System.out.println();
                            System.out.println("There are no users in database. Please, sign up first.");
                            System.out.println();
                            break;
                        } else {
                            if(isLogged == true) {
                                System.out.println();
                                System.out.println("You're already logged.");
                                System.out.println();
                                break;
                            } else {
                                for(int i = 1; i <= 3; i++) {
                                    System.out.println();
                                    System.out.print("Enter username: ");
                                    String matchUsername = input.nextLine().trim();
        
                                    System.out.print("Enter password: ");
                                    String matchPassword = input.nextLine().trim();
        
                                    if(matchPassword.isEmpty() || matchUsername.isEmpty()){
                                        System.out.println();
                                        System.out.println("Please, fill all fields.");
                                        System.out.println();
                                        System.out.println("Remaining attempts: "  + (3-i));
                                    } else if(username.equals(matchUsername) && password.equals(matchPassword)) {
                                        System.out.println();
                                        System.out.println("You're logged.");
                                        System.out.println();
                                        isLogged = true;
                                        break;
                                    } else {
                                        System.out.println();
                                        System.out.println("Username or password is incorrect.");
                                        System.out.println();
                                        System.out.println("Remaining attempts: "  + (3-i));
                                    }
                                }

                                if(isLogged == true) {
                                    continue;
                                } else {
                                    System.out.println();
                                    System.out.println("Access denied.");
                                    System.out.println();
                                    username = null;
                                    password = null;
                                    continue;
                                }
                            }
                        }
    
                    case 3:
                        if(isLogged == false) {
                            System.out.println();
                            System.out.println("Must log in first.");
                            System.out.println();
                            break;
                        } else {
                            System.out.println();
                            System.out.println("Logged as: " + username);
                            System.out.println();
                            break;
                        }
    
                    case 4:
                        System.out.println();
                        System.out.println("Exiting...");
                        break;
                }
    
                if(intChoice == 4) {
                    break;
                }

            } catch(NumberFormatException e) {
                System.out.println();
                System.out.println("Please, only use numbers. ");
                System.out.println();
                continue;
            }
        } 

        input.close();
    }
}