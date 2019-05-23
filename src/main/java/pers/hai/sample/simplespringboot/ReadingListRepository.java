package pers.hai.sample.simplespringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.hai.sample.simplespringboot.model.Book;

import java.util.List;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-23 14:22
 * Last Modify: 2019-05-23
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);

}
