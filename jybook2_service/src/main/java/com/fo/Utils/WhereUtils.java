package com.fo.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
public class WhereUtils {
    private StringBuilder where;
    private List<Object> parms = new ArrayList();

    private WhereUtils(String sql) {
        this.where = new StringBuilder(sql);
    }

    public static WhereUtils ins(String sql) {
        if(sql == null) {
            sql = "";
        }

        return new WhereUtils(sql);
    }

    public WhereUtils addOrderBy(String sql) {
        this.where.append(sql);
        return this;
    }

    public WhereUtils append(String sql) {
        this.where.append(sql);
        return this;
    }

    public WhereUtils addGroupBy(String sql) {
        this.where.append(sql);
        return this;
    }

    public String getAllSql() {
        return this.where.toString();
    }

    public String getCountSql(String field) {
        return this.countSql(this.getAllSql(), field);
    }

    public String getCountSql() {
        return this.countSql(this.getAllSql(), (String)null);
    }

    private String countSql(String sql, String field) {
        String tag = "FROM ";
        int pos = sql.toUpperCase().indexOf("FROM ");
        if(pos < 0) {
            throw new IllegalArgumentException("sql must does not match [select ... from ...] or [from ...]: " + sql);
        } else {
            return this.isEmpty(field)?"select count(*) " + sql.substring(pos):"select count(" + field + ")" + sql.substring(pos);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public List<Object> getParms() {
        return this.parms;
    }

    public WhereUtils contains(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" like ? ");
            this.parms.add("%" + par + "%");
            return this;
        }
    }

    public WhereUtils endWith(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" like ? ");
            this.parms.add("%" + par);
            return this;
        }
    }

    public WhereUtils startWith(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" like ? ");
            this.parms.add(par + "%");
            return this;
        }
    }

    public WhereUtils andEq(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" = ?");
            this.parms.add(par);
            return this;
        }
    }

    public WhereUtils andGe(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" >= ?");
            this.parms.add(par);
            return this;
        }
    }

    public WhereUtils andGt(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" > ? ");
            this.parms.add(par);
            return this;
        }
    }

    public WhereUtils andLe(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" <= ? ");
            this.parms.add(par);
            return this;
        }
    }

    public WhereUtils andLt(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" < ? ");
            this.parms.add(par);
            return this;
        }
    }

    public WhereUtils andNe(String field, Object par) {
        if(this.nullEmpty(par)) {
            return this;
        } else {
            this.where.append(" and ").append(field).append(" <> ? ");
            this.parms.add(par);
            return this;
        }
    }

    private boolean nullEmpty(Object par) {
        if(par == null) {
            return true;
        } else {
            if(par instanceof String) {
                String spar = (String)par;
                if(spar.isEmpty()) {
                    return true;
                }
            }

            return false;
        }
    }
}
