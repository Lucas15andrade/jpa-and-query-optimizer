delete from nopt.aluno
delete from nopt.matricula

do $$
begin
for r in 1..10000 loop
	insert into opt.aluno  (id, nome, curso_id) values (r, 'Aluno ' || r, 1);
	insert into opt.aluno  (id, nome, curso_id) values (10000 + r, 'Aluno ' || 10000 + r, 2);
end loop;
end;
$$;

select count(*) from opt.aluno

do $$
declare
	ano integer := 2010;
	periodo integer := 1;
	total_alunos integer := 20000;
	total_matriculas integer := 10;
begin
for r in 1..total_alunos loop
	for s in 1..total_matriculas loop
		ano := 2010 + floor(random() * 8 + 1)::int;
		insert into opt.matricula  (id, ano, periodo, disciplina_id, aluno_id) 
		values (nextval('hibernate_sequence'), ano, 1, floor(random() * 200)::int , r );
	end loop;
end loop;
end;
$$;