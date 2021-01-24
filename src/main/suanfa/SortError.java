package suanfa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @Author: zhanglin
 * @Date: 2018/12/3
 * @Time: 6:43 PM
 * java.lang.IllegalArgumentException: Comparison method violates its general contract!
 * 没测出来
 */
public class SortError {
    public static void main(String[] args) {
        Arrays.sort(new Bean[]{new Bean(7), new Bean(5), new Bean(null),new Bean(null),new Bean(null), new Bean(5),new Bean(null)}, new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                 if (o2.a == null  ) {
                    return -1;
                }
                 if (o1.a == null){
                     return 1;
                }
                return o1.a.compareTo(o2.a);
            }
        });
    }

    static class Bean {
        Integer a;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Bean)) return false;
            Bean bean = (Bean) o;
            return Objects.equals(a, bean.a);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a);
        }

        public Bean(Integer a) {
            this.a = a;
        }
    }
}
