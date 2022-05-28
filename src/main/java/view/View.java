package view;

import repository.*;

public  interface  View {
    RepositoryBook bookRepository = new RepositoryBook();
    RepositoryCourse courseRepository = new RepositoryCourse();
    RepositoryPerson personRepository = new RepositoryPerson();
    RepositotyEnrolment enrolmetRepository = new RepositotyEnrolment();
}
