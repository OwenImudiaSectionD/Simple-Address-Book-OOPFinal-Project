import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
    
        //Contact Class
        class Contact {
            String name;
            String phoneNumber;
            String email;
            
            //Constructor
            Contact(String name, String phoneNumber, String email) {
                this.name = name;
                this.phoneNumber = phoneNumber;
                this.email = email;
            }
        
            public String toString() {
                return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
            }
        }

//Phone Book
        System.out.println("Welcome to the Simple Address Book!");
        System.out.println("                                             ");

        Contact[] contacts = new Contact[20];
        int count = 0;

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("---------------------------------------------");
            System.out.println("######--Address Book Menu--######");
            System.out.println("---------------------------------------------");
            System.out.println("                                             ");
            System.out.println("Select one choice between 1 - 5");
            System.out.println("                                             ");
            System.out.println("1. Add a new Contact");
            System.out.println("                                             ");
            System.out.println("2. Delete an Existing Contact");
            System.out.println("                                             ");
            System.out.println("3. Update an Existing Contact");
            System.out.println("                                             ");
            System.out.println("4. Display all Contacts");
            System.out.println("                                             ");
            System.out.println("5. Exit");
            System.out.println("                                             ");
            System.out.print("Enter your choice here; ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
                if (choice == 1){
                    if (count < contacts.length) {
                        System.out.print("Enter contact name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter phone number: ");
                        String phone = scanner.nextLine();

                        System.out.print("Enter email address: ");
                        String email = scanner.nextLine();

                    contacts[count] = new Contact(name, phone, email);
                    count++;

                    System.out.println("Contact added successfully!");

                } else {
                    System.out.println("Address book is full!");
                }
                }else if(choice == 2){
                    System.out.print("Enter the name of the contact to delete: ");
                    
                    String nameToDelete = scanner.nextLine();
                    boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (contacts[i].name.equalsIgnoreCase(nameToDelete)) {
                        // Shift remaining contacts left
                        for (int j = i; j < count - 1; j++) {
                            contacts[j] = contacts[j + 1];
                        }
                        contacts[count - 1] = null;
                        count--;
                        System.out.println("Contact deleted.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Contact not found.");
                }
                }else if(choice == 3){
                System.out.print("Enter the name of the contact to update: ");
                System.out.println("                                             ");
                    String nameToUpdate = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (contacts[i].name.equalsIgnoreCase(nameToUpdate)) {
                            System.out.print("Enter new phone number: ");
                            System.out.println("                                             ");
                            contacts[i].phoneNumber = scanner.nextLine();
                            System.out.print("Enter new email address: ");
                            System.out.println("                                             ");
                            contacts[i].email = scanner.nextLine();
                            System.out.println("Contact updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                }else if(choice == 4){
                    if (count == 0) {
                        System.out.println("No contacts to display.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println(contacts[i]);
                        }
                    }
                }else if(choice == 5){
                    running = false;
                }else{
                    System.out.println("Invalid Choice. Please try again");
                };
        };
        
    };
    
};
