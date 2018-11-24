/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/28, create
 */

# ifndef _AW_PRICE_H_
# define _AW_PRICE_H_

int init_price(void);

int price_subscribe(nw_ses *ses, const char *market);
int price_unsubscribe(nw_ses *ses);
int price_send_last(nw_ses *ses, const char *market);

# endif

