package com.dyj.web.domain.vo;

import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.RetainConsultCard;

import java.util.List;

/**
 * @author danmo
 * @date 2024-04-09 17:40
 **/
public class RetainConsultCardVo extends DyResult<BaseVo> {

    private List<RetainConsultCard> cards;

    public List<RetainConsultCard> getCards() {
        return cards;
    }

    public void setCards(List<RetainConsultCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "RetainConsultCardVo{" +
                "cards=" + cards +
                '}';
    }
}
