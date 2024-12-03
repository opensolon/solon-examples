/*
 * Copyright 2017-2024 noear.org and authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo7031;


import org.agrona.sbe.solon.SbeInput;
import org.agrona.sbe.solon.SbeOutput;
import org.agrona.sbe.solon.SbeSerializable;

/**
 * @author noear 2023/8/16 created
 */
public class OrderDo implements SbeSerializable {
    private long orderId;
    private String title = "";

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void serializeRead(SbeInput in) {
        orderId = in.readLong();
        title = in.readString();
    }

    @Override
    public void serializeWrite(SbeOutput out) {
        out.writeLong(orderId);
        out.writeString(title);
    }

    @Override
    public String toString() {
        return "OrderDo{" +
                "orderId=" + orderId +
                "title=" + title +
                '}';
    }
}
