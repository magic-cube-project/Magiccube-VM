/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/27, create
 */

# ifndef _AW_DEPTH_H_
# define _AW_DEPTH_H_

int init_depth(void);

int depth_subscribe(nw_ses *ses, const char *market, uint32_t limit, const char *interval);
int depth_send_clean(nw_ses *ses, const char *market, uint32_t limit, const char *interval);
int depth_unsubscribe(nw_ses *ses);

# endif

