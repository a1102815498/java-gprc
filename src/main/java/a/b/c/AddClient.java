package a.b.c;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AddClient {
    ManagedChannel managedChannel;
    AddServiceGrpc.AddServiceBlockingStub stub;
    public static void main(String[] args) {

        AddClient addClient = new AddClient();
        int a = 1;
        int b = 1;
        AddReply add = addClient.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(add.getRes());


    }
    public AddClient(){
         managedChannel = ManagedChannelBuilder.forAddress("127.0.0.1",9999).usePlaintext()
                .build();

         stub = AddServiceGrpc.newBlockingStub(managedChannel);

    }
}
