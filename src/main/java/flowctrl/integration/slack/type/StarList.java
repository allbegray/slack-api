package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StarList {

	protected List<StarItem> items;
	protected Paging paging;

	public List<StarItem> getItems() {
		if (items == null) {
			items = new ArrayList<StarItem>();
		}
		return items;
	}

	public void setItems(List<StarItem> items) {
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
		return "StarList [items=" + items + ", paging=" + paging + "]";
	}

}