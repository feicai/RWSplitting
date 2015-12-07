package sxq.demo.mapper;

import java.util.List;
import java.util.Map;

/**
 * BaseMapper
 * @author sunxueqiang
 *
 * @param <T>
 */
public interface BaseMapper<T> {
    
    /**
     * 保存
     * @param entity
     * @return
     */
    int save(T entity);
    
    /**
     * 修改
     * @param entity
     * @return
     */
    int update(T entity);
    
    /**
     * 删除
     * @param entity
     * @return
     */
    int delete(T entity);
    
    /**
     * 根据Id删除
     * @param id
     * @return
     */
    int deleteById(Integer id);
    
    /**
     * 根据Id查询对象
     * @param id
     * @return
     */
    T selectById(Integer id);
    
    /**
     * 根据参数查询
     * @return
     */
    List<T> queryByParams(Map<String, Object> params);
    
}
