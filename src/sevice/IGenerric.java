package sevice;

import java.util.List;

public interface IGenerric<G> {
    ////triển khai các hàm chung nhất cho các class thừ kế sau nó
     List<G> finAll();
    void save(G g);
    G findById(int id);
    void remove(int id);

    void edit(G g);

}
