/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

/**
 *
 * @author DELL
 */
public class ApProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       admin a=new admin();
    // a.add_movie("Verna", "Urdu","Thriller", "2:30", "It is a 2017 Pakistani social-drama film", "12.30pm", "3:00pm", "Monday","11-26-2019","C:UsersDELLDesktopVerna_(film)2.jpg");
     a.Load_movies();
// movie m;
//           m=a.GetMovie(date);
//      a.add_movie("Joker", "English","Action", "3:00", "The film, based on DC Comics characters", "2:30pm", "5:30pm", "Tuesday");
//      a.add_movie("Jawani Phir Nhi Ani", "Urdu","Comedy", "3:00","JPNA is a 2015 Pakistani comedy film .", "4:00pm", "7:00pm", "Wednesday");
//      a.add_movie("Superstar","Urdu", "Romantic", "2:45", "Superstar is a 2019 Pakistani romantic film.", "3:30pm", "6:30pm", "Thursday");
//      a.add_movie("maleficient", "English","Fantasy", "2:00", "Maleficent is fairy living in the Moors.", "2:00pm", "4:00pm", "Friday");
//      a.add_movie("Jannan", "Urdu", "Romantic Comedy", "2:30","Janaan is a Pakistani comedy film", "7:30pm", "9:00pm", "Saturday");
//      a.add_movie("3Bahadur", "Urdu","Animation", "3:00", "Animation based movie","5:30pm", "8:30pm", "Sunday");
     
     a.display_movie();
    }
}
