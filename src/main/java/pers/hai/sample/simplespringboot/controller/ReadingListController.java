package pers.hai.sample.simplespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.hai.sample.simplespringboot.ReadingListRepository;
import pers.hai.sample.simplespringboot.model.Book;

import java.util.List;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-23 14:21
 * Last Modify: 2019-05-23
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);

        if (null != readingList) {
            model.addAttribute("books", readingList);
        }

        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
