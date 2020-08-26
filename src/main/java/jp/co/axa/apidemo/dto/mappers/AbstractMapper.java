package jp.co.axa.apidemo.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract mapper function for dto to entity change
 * <br> Could be transferred in a separate common project
 *
 * @author bertrand.hieronymus
 * @param <T> Entity Class
 * @param <V> DTO class
 */
public abstract class AbstractMapper<T, V> {

    /**
     * Map from entity of type <T> to dto of type <V>
     *
     * @param entity
     * @return
     */
    public abstract V mapToDto(T entity);

    /**
     * Map from dto of type <V> to entity of type  <T>
     *
     * @param dto
     * @return
     */
    public abstract T mapToEntity(V dto);

    /**
     * Map from entity list of type  <T> to dto of type <V>
     *
     * @param entityList
     * @return
     */
    public List<V> mapToDtoList(List<T> entityList) {
        if (entityList == null) {
            return null;
        }
        return entityList.stream()
                .map(entity -> mapToDto(entity))
                .collect(Collectors.toList());
    }

    /**
     * Map from dto list of type  <V> to entity of type  <T>
     *
     * @param entityList
     * @return
     */
    public List<T> mapToEntityList(List<V> entityList) {
        if (entityList == null) {
            return null;
        }
        return entityList.stream()
                .map(entity -> mapToEntity(entity))
                .collect(Collectors.toList());
    }
}
