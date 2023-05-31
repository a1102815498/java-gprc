package a.b.c;

import io.grpc.ServerBuilder;

import java.io.IOException;

public class AddServer extends AddServiceGrpc.AddServiceImplBase{
    public static void main(String[] args) throws IOException {
        ServerBuilder.forPort(9999).addService(new AddServer()).build().start();
        while(true){

        }
    }


    public void add(a.b.c.AddRequest request,
                    io.grpc.stub.StreamObserver<a.b.c.AddReply> responseObserver){

        int res =add(request.getA(),request.getB());
        responseObserver.onNext(AddReply.newBuilder().setRes(res).build());
        responseObserver.onCompleted();

    }

    private int add(int a,int b){
        return a+b;
    }
}
