/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5.model;



public class Mail {
    
    private final String mail;
    
    public Mail(String email) {
        this.mail = email;
    }
    
    public String getDomain() {
        String [] dominio = this.mail.split("@");
        return dominio[1];
    } 
    
}


