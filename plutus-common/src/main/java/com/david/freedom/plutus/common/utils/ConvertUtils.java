package com.david.freedom.plutus.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


/**
 * by wangyf14377
 */
public class ConvertUtils {
    private static final Logger logger = LoggerFactory.getLogger(ConvertUtils.class);


    public static <T, E> E convert(T t, Function<T, E> function) {
        if (t != null) {
            return function.apply(t);
        }
        return null;
    }

    public static <T, E> E convert(T t, E e) {
        if (t == null) {
            return null;
        }
        BeanUtils.copyProperties(t, e);
        return e;
    }

    /**
     * 支持继承类之间的转化
     *
     * @param orginList
     * @param claz
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E > List<E> convertList(List<T> orginList, Class<E> claz) {
        List<E> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(orginList)) {
            return list;
        }
        for (T t : orginList) {
            if (t == null) {
                continue;
            }
            try {
                E e = claz.newInstance();
                list.add(convert(t, e));
            } catch (Exception ex) {
                logger.error("转换异常convertList", ex);
            }
        }
        return list;
    }

    public static <T, E> List<E> getPropertiesList(Collection<T> userInfoList, Function<T, E> getPropertyFunction) {
        List<E> list = new ArrayList<>();
        if (userInfoList != null) {
            for (T info : userInfoList) {
                if (info != null) {
                    E e = getPropertyFunction.apply(info);
                    if (e != null) {
                        list.add(e);
                    }
                }
            }
        }
        return list;
    }

    public static <T, E> List<E> getDistinctPropertiesList(Collection<T> userInfoList, Function<T, E> getPropertyFunction) {
        List<E> list = new ArrayList<>();
        if (userInfoList != null) {
            for (T info : userInfoList) {
                if (info != null) {
                    E e = getPropertyFunction.apply(info);
                    if (e != null && !list.contains(e)) {
                        list.add(e);
                    }
                }
            }
        }
        return list;
    }

    public static <K, V> List<V> getMapValues(Map<K, V> map) {
        List<V> result = new ArrayList<>();
        if (map != null) {
            for (Map.Entry<K, V> kvEntry : map.entrySet()) {
                result.add(kvEntry.getValue());
            }
        }
        return result;
    }

    public static <K, V> Map<K, V> toMap(List<V> list, Function<V, K> getKeyFunction) {
        Map<K, V> map = new HashMap<K, V>();
        if (!CollectionUtils.isEmpty(list)) {
            for (V v : list) {
                if (v != null) {
                    K k = getKeyFunction.apply(v);
                    if (k != null) {
                        map.put(k, v);
                    }
                }
            }
        }
        return map;
    }


    public static <K, V, P> Map<K, P> toMapProperties(List<V> list, Function<V, K> getKeyFunction, Function<V, P> getPropertyFunction) {
        Map<K, P> map = new HashMap<K, P>();
        if (!CollectionUtils.isEmpty(list)) {
            for (V v : list) {
                K k = getKeyFunction.apply(v);
                if (k != null) {
                    map.put(k, getPropertyFunction.apply(v));
                }

            }
        }
        return map;
    }

    public static <K, V> Map<K, BigDecimal> toCalculatedGroupMap(List<V> list, Function<V, K> getKeyFunction, Function<V, BigDecimal> calculateFuction) {
        Map<K, BigDecimal> result = new HashMap<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (V info : list) {
                if (info != null) {
                    K key = getKeyFunction.apply(info);
                    if (key != null) {
                        BigDecimal value = calculateFuction.apply(info);
                        BigDecimal temp = result.get(key);
                        result.put(key, temp == null ? value : temp.add(value));
                    }
                }
            }
        }
        return result;
    }

    public static <K, V> Map<K, List<V>> toGroupMap(List<V> list, Function<V, K> getKeyFunction) {
        Map<K, List<V>> result = new HashMap<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (V info : list) {
                if (info != null) {
                    K key = getKeyFunction.apply(info);
                    if (key != null) {
                        List<V> temp = result.get(key);
                        if (temp == null) {
                            temp = new ArrayList<>();
                            result.put(key, temp);
                        }
                        temp.add(info);
                    }
                }

            }
        }
        return result;
    }


    public static <K, V> List<K> toList(List<V> list, Function<V, K> getKeyFunction) {
        List<K> result = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (V v : list) {
                if (v != null) {
                    K apply = getKeyFunction.apply(v);
                    if (apply != null) {
                        result.add(apply);
                    }
                }

            }
        }
        return result;
    }


    public static <K, V, T> T getMapPropeties(Map<K, V> map, K key, Function<V, T> function) {
        if (map != null) {
            V v = map.get(key);
            if (v != null) {
                return function.apply(v);
            }
        }
        return null;
    }


    public static <E> BigDecimal calculateAmt(List<E> list, Function<E, BigDecimal> function) {
        BigDecimal amount = BigDecimal.ZERO;
        if (!CollectionUtils.isEmpty(list)) {
            for (E info : list) {
                if (info != null) {
                    if (function.apply(info) == null) {
                        continue;
                    }
                    amount = amount.add(function.apply(info));
                }
            }
        }
        return amount;
    }

}
