package com.example.demo.Repository;

import com.example.demo.domain.Mapping.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by panbingcan on 2018/1/4.
 */
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    Book findByName(String name);

    List<Book> findByNameContaining(String name);
//    @Autowired
//    private IStudentRepository repository;
//
//    //无关代码略
//
//    @Override
//    public List<Student> getStudent(String studentNumber,String name ,String nickName,
//                                    Date birthday,String courseName,float chineseScore,float mathScore,
//                                    float englishScore,float performancePoints) {
//        Specification<Student> specification = new Specification<Student>(){
//
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                //用于暂时存放查询条件的集合
//                List<Predicate> predicatesList = new ArrayList<>();
//                //--------------------------------------------
//                //查询条件示例
//                //equal示例
//                if (!StringUtils.isEmpty(name)){
//                    Predicate namePredicate = cb.equal(root.get("name"), name);
//                    predicatesList.add(namePredicate);
//                }
//                //like示例
//                if (!StringUtils.isEmpty(nickName)){
//                    Predicate nickNamePredicate = cb.like(root.get("nickName"), '%'+nickName+'%');
//                    predicatesList.add(nickNamePredicate);
//                }
//                //between示例
//                if (birthday != null) {
//                    Predicate birthdayPredicate = cb.between(root.get("birthday"), birthday, new Date());
//                    predicatesList.add(birthdayPredicate);
//                }
//
//                //关联表查询示例
//                if (!StringUtils.isEmpty(courseName)) {
//                    Join<Student,Teacher> joinTeacher = root.join("teachers",JoinType.LEFT);
//                    Predicate coursePredicate = cb.equal(joinTeacher.get("courseName"), courseName);
//                    predicatesList.add(coursePredicate);
//                }
//
//                //复杂条件组合示例
//                if (chineseScore!=0 && mathScore!=0 && englishScore!=0 && performancePoints!=0) {
//                    Join<Student,Examination> joinExam = root.join("exams",JoinType.LEFT);
//                    Predicate predicateExamChinese = cb.ge(joinExam.get("chineseScore"),chineseScore);
//                    Predicate predicateExamMath = cb.ge(joinExam.get("mathScore"),mathScore);
//                    Predicate predicateExamEnglish = cb.ge(joinExam.get("englishScore"),englishScore);
//                    Predicate predicateExamPerformance = cb.ge(joinExam.get("performancePoints"),performancePoints);
//                    //组合
//                    Predicate predicateExam = cb.or(predicateExamChinese,predicateExamEnglish,predicateExamMath);
//                    Predicate predicateExamAll = cb.and(predicateExamPerformance,predicateExam);
//                    predicatesList.add(predicateExamAll);
//                }
//                //--------------------------------------------
//                //排序示例(先根据学号排序，后根据姓名排序)
//                query.orderBy(cb.asc(root.get("studentNumber")),cb.asc(root.get("name")));
//                //--------------------------------------------
//                //最终将查询条件拼好然后return
//                Predicate[] predicates = new Predicate[predicatesList.size()];
//                return cb.and(predicatesList.toArray(predicates));
//            }
//
//
//        };
//        return repository.findAll(specification);
//    }
//
//}
}
