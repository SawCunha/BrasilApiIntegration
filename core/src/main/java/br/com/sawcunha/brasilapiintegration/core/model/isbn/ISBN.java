package br.com.sawcunha.brasilapiintegration.core.model.isbn;

import br.com.sawcunha.brasilapiintegration.core.enums.ProvidersISBN;
import br.com.sawcunha.brasilapiintegration.core.model.Base;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ISBN extends Base {

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private String synopsis;
    private Integer year;
    private String format;
    @SerializedName("page_count")
    private Integer pageCount;
    private String location;
    @SerializedName("retail_price")
    private String retailPrice;
    @SerializedName("cover_url")
    private String coverUrl;
    private ProvidersISBN provider;

    private Set<String> authors;
    private Set<String> subjects;
    private Dimension dimensions;
}
