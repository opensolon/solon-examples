package demoC001.config;

import org.noear.solon.ai.AiConfig;
import org.noear.solon.ai.embedding.EmbeddingConfig;
import org.noear.solon.ai.embedding.EmbeddingModel;
import org.noear.solon.ai.rag.loader.MarkdownLoader;
import org.noear.solon.ai.rag.repository.InMemoryRepository;
import org.noear.solon.ai.rag.repository.WebSearchRepository;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.net.http.HttpUtils;

/**
 * @author noear 2025/2/25 created
 */
@Configuration
public class RagConfig {
    @Bean
    public EmbeddingModel embeddingModel(@Inject("${solon.ai.embed.bgem3}") EmbeddingConfig config) {
        return EmbeddingModel.of(config).build();
    }

    //作为默认知识库
    @Bean(name = "searchRepository", typed = true)
    public WebSearchRepository searchRepository(@Inject("${solon.ai.repo.websearch}") AiConfig config) {
        return new WebSearchRepository(null, config);
    }

    @Bean("localRepository")
    public InMemoryRepository localRepository(EmbeddingModel embeddingModel) {
        return new InMemoryRepository(embeddingModel);
    }

    @Bean
    public void localRepositoryInit(@Inject("localRepository") InMemoryRepository localRepository) throws Exception {
        //用 MarkdownLoader 加载网载上的 md 文件（）
        MarkdownLoader loader = new MarkdownLoader(HttpUtils
                .http("https://solon.noear.org/article/about?format=md")
                .exec("GET")
                ::body);

        //存入知识库
        localRepository.store(loader.load());
    }
}
