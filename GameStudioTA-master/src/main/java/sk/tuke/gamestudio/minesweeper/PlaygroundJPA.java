package sk.tuke.gamestudio.minesweeper;

import sk.tuke.gamestudio.entity.Rating;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.entity.Student;
import sk.tuke.gamestudio.entity.StudyGroup;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class PlaygroundJPA {

    @PersistenceContext
    private EntityManager entityManager;

    public void play(){
        System.out.println("Opening JPA playground.");

//        entityManager.persist(new StudyGroup("zakladna"));
//        entityManager.persist(new StudyGroup("mierne pokrocila"));
//        entityManager.persist(new StudyGroup("pokrocila"));

        String firstName = "Marta";
        String lastName = "Velela";
        int group = 1;

        List<StudyGroup> studyGroups= entityManager.createQuery("select g from StudyGroup g")
                .getResultList();

        int noOfGroups = studyGroups.size();

        for(int i=0;i<noOfGroups;i++){
            System.out.println(i+" "+studyGroups.get(i));
        }

        entityManager.persist(new Student(firstName,lastName,studyGroups.get(group)));

        List<Student> students= entityManager.createQuery("select s from Student s")
                .getResultList();

        System.out.println(students);




        System.out.println("Closing JPA playground.");
    }

}
