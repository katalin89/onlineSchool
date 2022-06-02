package view;

import repository.*;

public abstract class View {
    public static final RepositoryBook bookRepository = new RepositoryBook();
    public static final RepositoryCourse courseRepository = new RepositoryCourse();
    public static final RepositoryPerson personRepository = new RepositoryPerson();
    public static final RepositotyEnrolment enrolmetRepository = new RepositotyEnrolment();
}
