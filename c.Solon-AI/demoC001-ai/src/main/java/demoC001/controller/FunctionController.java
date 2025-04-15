package demoC001.controller;

import org.noear.solon.ai.chat.ChatModel;
import org.noear.solon.ai.chat.annotation.ToolMapping;
import org.noear.solon.ai.chat.annotation.ToolParam;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;

import java.io.IOException;

/**
 * @author noear 2025/2/25 created
 */
@Mapping("function")
@Controller
public class FunctionController {
    @Inject
    ChatModel chatModel;

    //函数调用
    @Mapping("weather")
    public String weather(@Param(defaultValue = "今天杭州的天气如何？") String message) throws IOException {
        return chatModel.prompt(message)
                .options(o -> o.toolsAdd(Tools.instance))
                .call().getMessage().getContent();
    }

    public static class Tools {
        static final Tools instance = new Tools();

        //天气查询
        @ToolMapping(description = "获取指定城市的天气情况")
        public String get_weather(@ToolParam(description = "根据用户提到的地点推测城市") String location) {
            if (location == null) {
                throw new IllegalStateException("arguments location is null (Assistant recognition failure)");
            }

            return "晴，24度"; //可使用 “数据库” 或 “网络” 接口根据 location 查询合适数据;
        }
    }
}