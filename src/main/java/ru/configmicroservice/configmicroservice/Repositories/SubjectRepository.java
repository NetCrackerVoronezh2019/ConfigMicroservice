package ru.configmicroservice.configmicroservice.Repositories;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.configmicroservice.configmicroservice.Entitys.Subject;


@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject,Long>{

}
