/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/04, create
 */

# ifndef _ME_DUMP_H_
# define _ME_DUMP_H_

# include "ut_mysql.h"

int dump_orders(MYSQL *conn, const char *table);
int dump_markets(MYSQL *conn, const char *table);
int dump_balance(MYSQL *conn, const char *table);

# endif

