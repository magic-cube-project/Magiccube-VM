/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/27, create
 */

# ifndef _AW_ORDER_H_
# define _AW_ORDER_H_

int init_order(void);

int order_subscribe(uint32_t user_id, nw_ses *ses, const char *market);
int order_unsubscribe(uint32_t user_id, nw_ses *ses);
int order_on_update(uint32_t user_id, int event, json_t *order);

# endif

