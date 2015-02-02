@num_test = 500
@in_0 = []
@in_org_0 = []
@out = []


def load_test
    f = File.new("judge/tests/ugly-number.txt")
    @in_0 = read_int_array(f)
    @in_org_0 = @in_0.dup
    @out = read_int_array(f)
    f.close
end

def judge
    load_test

    start_time = Time.now

    (0...@num_test).each do |i|
        answer = kth_ugly_number(@in_0[i]) 
        if answer != @out[i]
            print "#{i+1} / #{@num_test};"
            print @in_org_0[i].to_s
            print ';'
            print answer.to_s
            print ';'
            print @out[i].to_s
            puts
            return
        end
    end

    runtime = (Time.now - start_time) * 1000.0
    puts('Accepted;' + runtime.to_i.to_s)
end