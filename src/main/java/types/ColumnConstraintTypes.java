package types;

/**
 * The types of column constraint used in create-table expression.
 *
 * @author Hao Lin
 * @version 1.0
 * @since 1.0
 */

public enum ColumnConstraintTypes {
    COL_AUTO_INC,
    COL_NOT_NULL,
    COL_PRIMARY_KEY,
    COL_UNIQUE
}
