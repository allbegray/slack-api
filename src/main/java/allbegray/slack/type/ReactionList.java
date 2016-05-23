package allbegray.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReactionList {

	protected List<ReactionItem> items;
	protected Paging paging;

	public List<ReactionItem> getItems() {
		if (items == null) {
			items = new ArrayList<ReactionItem>();
		}
		return items;
	}

	public void setItems(List<ReactionItem> items) {
		this.items = items;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "ReactionList [items=" + items + ", paging=" + paging + "]";
	}

}
