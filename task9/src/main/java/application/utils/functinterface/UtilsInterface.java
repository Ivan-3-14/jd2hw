package application.utils.functinterface;


import javax.persistence.EntityManager;

public class UtilsInterface {

    public static void superMethodInterface(MyInterfaceToDAO method, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        method.betweenBeginAndCommitted();
        entityManager.getTransaction().commit();
    }
}
