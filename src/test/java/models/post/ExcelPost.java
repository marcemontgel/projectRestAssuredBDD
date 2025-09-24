package models.post;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("posts")
public class ExcelPost {
    @ExcelCellName("id")
    private int id;
    @ExcelCellName("title")
    private String title;
    @ExcelCellName("likes")
    private int likes;
    @ExcelCellName("dislikes")
    private int dislikes;
    @ExcelCellName("views")
    private int views;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getViews() {
        return views;
    }

    @Override
    public String toString() {
        return "ExcelPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", views=" + views +
                '}';
    }
}
