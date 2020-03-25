package base;

import tk.mybatis.mapper.common.*;

public interface MyBaseMapper<T> extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {
}
